package com.appodealx.exchange.common.utils.xtract

import scala.xml.NodeSeq

sealed trait XPathNode extends Function[NodeSeq, NodeSeq]

case class IdxXPathNode(idx: Int) extends XPathNode {
  def apply(xml: NodeSeq): NodeSeq = xml(idx)
  override def toString = s"[$idx]"
}

case class KeyXPathNode(key: String) extends XPathNode {
  def apply(xml: NodeSeq): NodeSeq = xml \ key
  override def toString = s"/$key"
}

case class RecursiveXPathNode(key: String) extends XPathNode {
  def apply(xml: NodeSeq): NodeSeq = xml \\ key
  override def toString = s"//$key"
}

/**
 * Class representing an xpath.
 * It can be applied to a NodeSeq to get
 * a NodeSeq located at that path.
 *
 * @param path A sequence of [[XPathNode]]s to recursively
 * walk down the XML tree to the location of the path.
 */
case class XPath(path: List[XPathNode] = Nil) {
  /**
   * Equivalent of "/child" in xpath syntax.
   * @param child The name of the label of the child(ren).
   * @return a new [[XPath]] pointing to all children of this [[XPath]]
   *   with the given tag label.
   */
  def \(child: String) = XPath(path :+ KeyXPathNode(child))
  /**
   * Equivalent of "//child" in xpath.
   * @param child The name of the label of the descendents.
   * @return a new [[XPath]] that selects all descendents with
   *   the given tag label.
   */
  def \\(child: String) = XPath(path :+ RecursiveXPathNode(child))
  /**
   * Equivalent of "@attribute" in xpath.
   * @param attribute The name of the attribute to select
   * @return a new [[XPath]] that selects the attribute node with
   *   the given name
   */
  def \@(attribute: String) = XPath(path :+ KeyXPathNode("@" + attribute))
  /**
   * Concatenate two [[XPath]]s together
   */
  def ++(other: XPath) = XPath(path ++ other.path)
  /**
   * Equivalent of "[idx]" in xpath syntax.
   * @param idx The index of the node to select.
   * @return a new [[XPath]] that selects the node at index `idx` in the current selection.
   */
  def apply(idx: Int) = new XPath(path :+ IdxXPathNode(idx))

  /**
   * Equivalent of "/ *" in xpath syntax.
   * @return a new [[XPath]] that selects all children of the current selection
   */
  def children: XPath = XPath(path :+ KeyXPathNode("_"))

  /**
   * Apply this xpath to a NodeSeq.
   *
   * @param xml The NodeSeq to apply the path to.
   * @return the NodeSeq of the node(s) selected by this xpath.
   */
  def apply(xml: NodeSeq): NodeSeq = path.foldLeft(xml){ (x, p) => p(x) }

  override def toString = path.mkString

  /**
   * Create an [[XmlReader]] that reads the node(s) located at this xpath.
   * @param reader The reader to use on the node at this path
   */
  def read[A](implicit reader: XmlReader[A]): XmlReader[A] = XmlReader.at[A](this)(reader)

  def readOptional[A](implicit reader: XmlReader[A]): XmlReader[Option[A]] = XmlReader { xml =>
      apply(xml) match {
        case at if at.nonEmpty => reader.read(at).map(Option.apply)
        case _ => ParseSuccess(None)
      }
    }

  /**
   * The same as [[read]] but take the reader as a lazy argument so that it can be used in recursive
   * definitions.
   */
  def lazyRead[A](r: => XmlReader[A]): XmlReader[A] = XmlReader( xml => XmlReader.at[A](this)(r).read(xml))

  /**
   * Create an [[XmlReader]] that reads an attribute at the current path.
   * @param name the name of the attribute to read
   * @param reader The [[XmlReader]] to read the attribute with
   */
  def readAttribute[A](name: String)(implicit reader: XmlReader[A]): XmlReader[A] = XmlReader.attribute[A](name).compose(XmlReader.at[NodeSeq](this))

}

/**
 * The root [[XPath]] path.
 */
object XPath extends XPath(Nil) {
}
