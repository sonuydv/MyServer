package browser

import java.io.*
import java.net.Socket


fun main(){
    println("Enter server ip address to connect....")
    val serverName= readLine()
    try {
        val client= Socket(serverName,80)
        println("Connected to $serverName")
        val reader=BufferedReader(InputStreamReader(client.getInputStream()))
        val writer=PrintWriter(OutputStreamWriter(client.getOutputStream()))

        //Making default web page request
        val request="GET / HTTP/1.0\n\n"
        writer.write(request)
        writer.flush()

        //Printing response from server to console
        var data=reader.readLine()
        while(!data.isNullOrBlank()){
            println("$data")
            data=reader.readLine()
        }

    }catch (e:Exception){
        println("Could not connect to server...")
    }
}