package cl.ravenhill.edu.wasp
package files

import scala.io.Source

abstract class AbstractAudioFile(override val filename: String)
    extends AudioFile {

  override def play(): Unit = {
    val file = open()
    val audio = decode(file)
    play(audio)
    close()
  }

  private def open(): Source = {
    checkExtension()
    Source.fromFile(filename)
  }

  protected def checkExtension(): Unit

  protected def decode(file: Source): Audio

  private def play(audio: Audio): Unit = {
    println(s"Playing ${audio.title.getOrElse(filename)}")
  }

  private def close(): Unit = {
    println(s"Closing $filename")
  }
}
