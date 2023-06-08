
package cl.ravenhill.edu.wasp
package files

import scala.io.Source

class Mp3File(filename: String) extends AbstractAudioFile(filename) {
  override def checkExtension(): Unit = {
    if (!filename.endsWith(".mp3")) {
      throw new InvalidExtensionException("Filename must end with .mp3")
    }
  }

  override def decode(file: Source): Audio = {
    println("Decoding MP3 file")
    throw new NotImplementedError("Not implemented yet")
  }
}
