package System.Net;
import System.NotImplementedException;
import java.net._;
import java.io._;

class WebClient
{

	def DownloadData(url:String):Array[Byte] =
	{
      //Create connection
      val connection = new URL(url).openConnection().asInstanceOf[HttpURLConnection];

      val is = connection.getInputStream();
      val rd = new ByteArrayOutputStream();
      val buf = new Array[Byte](1024);

      var read = 0;
      do
      {
        read = is.read(buf, 0, buf.length);
        if (read != -1)
          rd.write(buf, 0, read);
      }
      while (read != -1);

      rd.flush();

      return rd.toByteArray();
	}

	def Dispose()
	{
		
	}
}