package playground;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Playground {
    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                /**
                 * COLOCAR AS DEFINIÇÕES DE ROTAS DENTRO DESTE ROUTE BUILDER
                 * */
                    from("timer://foo?delay=1")
                        .log("Logou :)");
                }
            });

            context.start();
            Thread.sleep(500000000); //Quanto tempo o contexto fica ativo
            context.stop();
        } catch(Exception e) {
            System.out.println("Exception is: " + e);
            e.printStackTrace();
        }
    }
}
