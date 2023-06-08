package cl.ravenhill.edu.wasp

import files.{AbstractAudioFile, AudioFile, FlacFile, Mp3File}

class Player private() {
  private val formats = Map(
    "mp3" -> { filename: String =>
      new Mp3File(filename)
    },
    "flac" -> { filename: String =>
      new FlacFile(filename)
    }
  )

  def play(filename: String): Unit = {
    val extension = filename.split("\\.").last
    val factory: String => AudioFile = formats.getOrElse(extension, { _: String =>
      throw new InvalidExtensionException(s"Extension $extension is not supported")
    })
    val file = factory(filename)
    file.play()
  }
}

object Player {
  private var instance: Option[Player] = None

  def getInstance(): Player = {
    if (instance.isEmpty) {
      instance = Some(new Player())
    }
    instance.get
  }
}
