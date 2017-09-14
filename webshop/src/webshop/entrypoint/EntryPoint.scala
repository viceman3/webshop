package webshop.entrypoint

import webshop.simulator._
import webshop.framework._
import webshop.app._

object EntryPoint {
    def main(args: Array[String]) ={
    println("Hello World!")
    val server =new Server(new ExperimentalHandler)
    val simulator =new Simulator(server)
    simulator.simulate()
  }

}