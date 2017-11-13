import java.io.File;

public class Test {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(7);
		System.out.println(8);
		// System.out.println(9);
		System.out.println(11);

		String string = new String();
		if (string == null) {

		}
		string="/Users/david/Downloads/apache-tomcat-7.0.69-idea/apache-tomcat-7.0.69/ImagesUpload/WEBUPLOAD/2017-09-27";

		File dirFile=new File(string);
		System.out.println("dirFile.exists():"+dirFile.exists());
		System.out.println("dirFile.isDirectory():"+dirFile.isDirectory());
		if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
			System.out.println("dirFile.isDirectory():"+dirFile.isDirectory());
		} else {
			System.out.println(2);
		}
	}
}
