# 🤖 mcp-demo-spring-python

## 🧠 Application Agentique avec Spring AI, MCP Protocol, NodeJS, Python et LLMs (OpenAI, Claude, LLaMA)

---

### ❗ Problème à résoudre :

> **"Créer une architecture flexible et extensible d'agents IA capables d'interagir avec des outils externes via le protocole MCP, en multi-langage (Java, NodeJS, Python), pour permettre la résolution intelligente de requêtes complexes."**

---

### 🔍 Description

Cette application montre comment :

- Mettre en place un **serveur MCP** (Spring Boot, NodeJS, Python)
- Intégrer un **client Spring AI** compatible avec Claude, LLaMA3.2 et OpenAI
- Créer un **agent intelligent** (`ToolCallbackProvider`, mémoire contextuelle, etc.)
- Appeler dynamiquement des **tools STDIO**
- **Tester via Swagger UI**, Postman et Front Angular/Thymeleaf

---

### ✅ Fonctionnalités principales

- 📁 **Lecture / écriture fichiers** via `@modelcontextprotocol/server-filesystem`
- 🔁 **Communication STDIO** entre le client Java et les tools (NodeJS, Python)
- 🧠 **Utilisation de modèles LLM** en interaction avec des outils réels
- ✔️ **Test complet** avec Postman et Swagger
- 🎨 **Intégration UI** (Angular ou Thymeleaf)

---

### 🛠️ Stack technique

| Composant | Description |
|----------|-------------|
| ![Spring](https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg) **Spring Boot / Spring AI** | Agent IA et orchestration |
| 🧠 **LLMs** | OpenAI (GPT-4), Claude, LLaMA |
| 🟢 **NodeJS** | Tools MCP (file-system) exécutés via NPX |
| 🐍 **Python** | Tools MCP exécutés via `uv` |
| 📦 **MCP Protocol** | Standardisé pour outils multilangages |
| 📬 **Postman / Swagger** | Test et documentation des endpoints |
| 🌐 **Angular / Thymeleaf** | Interface utilisateur (UI) |

---

### 📂 Structure du projet

<img width="457" height="247" alt="image" src="https://github.com/user-attachments/assets/23679997-af78-4ce5-8b1c-bcea982f608f" />


---

### 📊 Diagramme de flux (simplifié)

sequenceDiagram
    participant UI as 🧑 Utilisateur (Angular/Swagger)
    participant RestCtrl as 🌱 REST Controller
    participant Agent as 🧠 IA Agent
    participant LLM as 🧠 LLM (OpenAI/Claude)
    participant MCPClient as 🔁 MCP Client
    participant ToolNode as 🟢 Tool NodeJS
    participant ToolPython as 🐍 Tool Python

    UI->>RestCtrl: Envoie une requête (query)
    RestCtrl->>Agent: Transmet la requête
    Agent->>LLM: Envoie prompt + contexte + tools
    LLM->>MCPClient: Choix d’un tool (Node/Python)
    MCPClient->>ToolNode: Appel STDIO (ex: npx)
    MCPClient->>ToolPython: Appel STDIO (ex: uv)
    ToolNode-->>MCPClient: Réponse JSON
    ToolPython-->>MCPClient: Réponse JSON
    MCPClient-->>Agent: Résultat brut
    Agent-->>LLM: Observation
    LLM-->>Agent: Réponse finale
    Agent-->>RestCtrl: Résultat
    RestCtrl-->>UI: Réponse utilisateur


🚀 Démarrage rapide
Clone du projet

Configure .env avec ta clé OpenAI

Lance le backend : Spring Boot

Lance un outil via npx ou uv

Teste via Swagger (http://localhost:8066/swagger-ui.html)

🧪 Exemple de requête
POST /chat
{
  "query": "Crée un fichier nommé test.md avec le contenu Bonjour"
}
Réponse :

{
  "result": "Fichier test.md créé avec succès dans le répertoire autorisé"
}
🙌 Contribution
Les PR sont les bienvenues ! Pour tout bug ou question, ouvre une issue.

📄 Licence
MIT © 2025 – Elimane
