🤖 mcp-demo-spring-python

🧠 Application Agentique avec Spring AI, MCP Protocol, NodeJS, Python et LLMs (OpenAI, Claude, LLaMA)

❗ Problème à résoudre

"Créer une architecture flexible et extensible d'agents IA capables d'interagir avec des outils externes via le protocole MCP, en multi-langage (Java, NodeJS, Python), pour permettre la résolution intelligente de requêtes complexes."

🔍 Description

Cette application montre comment :

Mettre en place un serveur MCP (Spring Boot, NodeJS, Python)

Intégrer un client Spring AI compatible avec Claude, LLaMA3.2 et OpenAI

Créer un agent intelligent (ToolCallbackProvider, mémoire contextuelle, etc.)

Appeler dynamiquement des tools STDIO

Tester via Swagger UI, Postman et Front Angular/Thymeleaf

🗒️ Fonctionnalités principales

📂 Lecture / écriture fichiers via @modelcontextprotocol/server-filesystem

↻ Communication STDIO entre le client Java et les tools (NodeJS, Python)

🧠 Utilisation de modèles LLM en interaction avec des outils réels

✅ Test complet avec Postman et Swagger

🌐 Intégration UI (Angular ou Thymeleaf)

🛠️ Stack technique

Composant

Description

Spring Boot / Spring AI

Serveur et client MCP

OpenAI / Claude / LLaMA

Fournisseurs LLM

NodeJS

Serveur MCP tool STDIO

Python

Serveur MCP tool STDIO

Angular / Thymeleaf

Interfaces utilisateur

Docker (optionnel)

Conteneurisation

📂 Structure du projet

mcp-demo-spring-python
├── mcp-client               # Agent IA + REST Controller
│   ├── agents/              # IA logic
│   ├── controller/          # REST endpoints
│   ├── config/              # Spring config
│   └── application.yml
├── files/                   # Partage fichiers tools
├── mcp-nodejs-tool/         # Tool filesystem (NodeJS)
├── mcp-python-tool/         # Tool custom (Python)
└── frontend/                # Angular ou Thymeleaf

📊 Diagramme de flux

sequenceDiagram
    participant UI as Utilisateur
    participant API as REST Controller
    participant Agent as Agent IA
    participant LLM as Modèle LLM
    participant MCP as MCP Client (Spring)
    participant Tool as Tool MCP (NodeJS ou Python)

    UI->>API: Envoie requête
    API->>Agent: Transmet la query
    Agent->>LLM: Prépare prompt (contexte, outils)
    LLM->>MCP: Appelle outil via STDIO
    MCP->>Tool: Appelle le bon serveur Tool
    Tool-->>MCP: Résultat outil
    MCP-->>LLM: Observation
    LLM-->>Agent: Réponse finale
    Agent-->>API: Résultat
    API-->>UI: Affichage réponse

🥺 Tests & Déploiement

Démarrer l'application Spring Boot

Lancer un outil MCP STDIO :

NodeJS :

npx -y @modelcontextprotocol/server-filesystem "C:\\chemin\\vers\\files"

Python :

uv run --with mcp[cli] mcp run server.py

Appeler l’agent via Swagger ou Postman

Observer la chaîne complète d’exécution

🧠 Exemple de prompt

✍️ "Crée un fichier nommé elimane.md contenant mes notes sur Claude."

➔ LLM appellera filesystem tool → retournera un JSON → réponse intégrée dans l’output final.

