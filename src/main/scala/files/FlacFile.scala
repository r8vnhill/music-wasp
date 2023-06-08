
package cl.ravenhill.edu.wasp
package files

import scala.io.Source

class FlacFile(filename: String) extends AbstractAudioFile(filename) {
  override def checkExtension(): Unit = {
    if (!filename.endsWith(".flac")) {
      throw new InvalidExtensionException("Filename must end with .flac")
    }
  }

  override def decode(file: Source): Audio = {
    println("Decoding FLAC file")
    throw new NotImplementedError("Not implemented yet")
  }
}
