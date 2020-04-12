package server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket


const val PORT=9999
fun main(){

    val serverSocket=ServerSocket(PORT)
    println("Server is created on port $PORT")
    while (true){

            println("Waiting for a client to connect.....")
            var client=serverSocket.accept()
            println("A client is connected...")
            var reader=BufferedReader(InputStreamReader(client.getInputStream()))
            var writer=PrintWriter(OutputStreamWriter(client.getOutputStream()))
        while (client.isConnected){
            println("Session started....")
            try{
                val request=reader.readLine()
                println("Client request : $request\n")
                val rh=request.split(" ")
                if(request.isNotEmpty()){
                    writer.write("Your request : $request\n")
                    writer.flush()
                }
            }catch (e:Exception){
                writer.write("<h>Exception occurred</h>")
                writer.flush()
            }
        }


    }

}
