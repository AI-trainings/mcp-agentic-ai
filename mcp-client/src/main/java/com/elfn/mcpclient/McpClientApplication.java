package com.elfn.mcpclient;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpClientApplication.class, args);
    }

    /**
     * Configuration Spring Boot pour exécuter automatiquement une commande au démarrage de l'application.
     *
     * Cette commande :
     * 1. Liste les outils disponibles via chaque client MCP.
     * 2. Exécute un appel à l’outil "getCompanyByName" avec le nom "OCP".
     * 3. Affiche le résultat textuel retourné.
     *
     * @param clients Liste des clients MCP synchrones injectés automatiquement par Spring.
     * @return Un runner exécuté automatiquement au démarrage.
     */
    @Bean
    public CommandLineRunner commandLineRunner(List<McpSyncClient> clients) {
        return args -> clients.forEach(client -> {
            // Affichage des outils disponibles
            client.listTools().tools().forEach(tool -> {
                System.out.printf("""
                --- Name ---
                %s
                --- Description ---
                %s
                --- Schema ---
                %s
                """, tool.name(), tool.description(), tool.inputSchema());
            });

            // Préparation et envoi de la requête à l’outil
            String params = """
            {
                "name": "BCM COTE D'IVOIRE"
            }
            """;

            var result = client.callTool(new McpSchema.CallToolRequest("getCompanyByName", params));
            var content = (McpSchema.TextContent) result.content().get(0);

            // Affichage du résultat
            System.out.println("--- Résultat getCompanyByName ---");
            System.out.println(content.text());
        });
    }

}
