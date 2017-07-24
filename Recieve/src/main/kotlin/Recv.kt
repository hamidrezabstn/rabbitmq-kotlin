import com.rabbitmq.client.*
import java.io.IOException
import java.nio.charset.Charset


/**
 * Created by iransamaneh on 7/23/17.
 */

  

  fun main(argv : Array<String>){
    val QUEUE_NAME :String = "hello";
    val factory :ConnectionFactory = ConnectionFactory()
    factory.host = "localhost"
    val connection :Connection = factory.newConnection()
    val channel :Channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

      val consumer = object : DefaultConsumer(channel) {
          @Throws(IOException::class)
          override fun handleDelivery(consumerTag: String, envelope: Envelope,
                                      properties: AMQP.BasicProperties, body: ByteArray) {
              val message = String(body, Charset.forName("UTF-8"))
              println(" [x] Received '$message'")
          }
      }
      channel.basicConsume(QUEUE_NAME, true, consumer)
    }

