package com.appodealx.exchange.common.utils.xtract

trait XmlReaderExtensions
  extends IterableReaderExtensions
  with DoubleReaderExtensions

trait IterableReaderExtensions {
  // this apparently doesn't work as an implicit definition
  // if you need another implicit iterable class type just
  // extend this class and as seen in SeqReaderExtension
  class IterableReaderExtension[T, I <: Iterable[T]](iterableReader: XmlReader[I]) {
    /**
     * Filter an [[XmlReader]] of an Iterable so that it
     * requires at least `count` elements.
     * @param count The minimum number of elements to require
     * @return a new [[XmlReader]]
     */
    def atLeast(count: Int) = iterableReader
      .filter(MinCountError(count))(_.size >= count)
  }

  implicit class SeqReaderExtension[T](seqReader: XmlReader[List[T]])
    extends IterableReaderExtension[T, List[T]](seqReader)
}

trait DoubleReaderExtensions {
  implicit class DoubleReaderExtension(doubleReader: XmlReader[Double]) {
    /**
     * Filter an [[XmlReader]] so it requires a double to
     * be between `min` and `max` inclusive.
     * @param min The minimum allowed value
     * @param max The maximum allowed value
     * @return a new [[XmlReader]]
     */
    def inRange(min: Double, max: Double) = doubleReader
      .filter(RangeError(min, max)) { value =>
        min <= value && value <= max
      }
  }
}
