package client

import server.PORT
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.Socket

fun main(){
    try {
        val client= Socket("localhost", PORT)
        println("Connected to server....")
        val writer=PrintWriter(OutputStreamWriter(client.getOutputStream()))
        val reader=BufferedReader(InputStreamReader(client.getInputStream()))
      while (client.isConnected){
          println("Session started...")
          //request
          print("Enter request : ")
          val r= readLine()
          writer.write(r)
          writer.flush()
          //printing response
          println(reader.readLine())
      }

    }catch (e :Exception){
        println("Could communicate to server...")
    }

}