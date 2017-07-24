
import com.rabbitmq.client.ConnectionFactory

/**
 * Created by iransamaneh on 7/23/17.
 */
   

    fun main(args:Array<String>){
 	val QUEUE_NAME : String = "hello"
        val factory = ConnectionFactory()
        factory.host = "localhost"
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.queueDeclare(QUEUE_NAME, false, false, false, null)
        val message = "Hello World!"
        channel.basicPublish("", QUEUE_NAME, null, message.toByteArray())
        println(" [x] Sent '$message'")

        channel.close();
        connection.close();
    }

