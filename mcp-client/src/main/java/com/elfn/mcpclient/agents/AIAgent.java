package com.elfn.mcpclient.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

/**
 * Service représentant un agent conversationnel basé sur une intelligence artificielle.
 * Il utilise un client LLM (Large Language Model) avec des outils intégrés pour répondre aux requêtes utilisateur.
 *
 * @author Elimane
 */
@Service
public class AIAgent {

    private ChatClient chatClient;

    /**
     * Constructeur de l'agent IA.
     * Initialise le client LLM avec :
     * - un système par défaut qui demande de répondre à l'utilisateur en utilisant les outils fournis,
     * - un fournisseur de callbacks pour l'exécution des outils,
     * - un conseiller de mémoire de chat basé sur une fenêtre de 10 messages.
     *
     * @param chatClient Le builder du client de chat IA.
     * @param toolCallbackProvider Le fournisseur de callbacks pour les outils utilisés par l'agent.
     */
    public AIAgent(ChatClient.Builder chatClient, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultSystem("Answer user question using provided tools")
                .defaultAdvisors(MessageChatMemoryAdvisor
                        .builder(MessageWindowChatMemory.builder().maxMessages(10).build()).build())
                .build();
    }

    /**
     * Envoie une requête à l'agent IA et retourne la réponse générée.
     *
     * @param query La question de l'utilisateur.
     * @return La réponse de l'agent IA sous forme de texte.
     */
    public String askLLM(String query) {
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
