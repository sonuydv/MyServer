package server

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.ServerSocket
import java.net.Socket

class Server(port:Int) {
    private lateinit var clientSocket: Socket
      var server:ServerSocket
    private lateinit var writer: BufferedWriter
    init {
        server = ServerSocket(port)
        println("Server started and listening  at 9999")
    }
    fun acceptClient(){
        server.accept()
    }
    fun writer()=BufferedWriter(OutputStreamWriter(clientSocket.getOutputStream()))
    fun reader()=BufferedReader(InputStreamReader(clientSocket.getInputStream()))
}