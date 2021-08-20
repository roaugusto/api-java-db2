package br.com.demo.db2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.demo.db2.util.Crypt;

@SpringBootApplication
public class Db2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {

		if (args.length > 0) {
			if(args[0].equals("EncodeParam")) {
				if (args.length < 2) {
					System.out.println("Parâmetros inválidos");
					return;
				}
				String str = args[1];
				String strEncoded = Crypt.Encode(str);
				System.out.println("String encoded: " + strEncoded);
				return;
			}
			if(args[0].equals("DecodeParam")) {
				if (args.length < 2) {
					System.out.println("Parâmetros inválidos");
					return;
				}
				String str = args[1];
				String strDecoded = Crypt.Decode(str);
				System.out.println("String decoded: " + strDecoded);
				return;
			}
		}

		SpringApplication.run(Db2Application.class, args);
	}

}
