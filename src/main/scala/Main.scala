package cl.ravenhill.edu.wasp

object Main extends App {
  private val player = Player.getInstance()
  player.play("song.mp3")
  player.play("song.flac")
}