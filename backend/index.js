const express = require("express");
const dotenv = require("dotenv");
const { MongoClient } = require("mongodb");
const eventRoutes = require("./routes/eventRoutes");
const userRoutes = require("./routes/userRoutes")
dotenv.config();

const app = express();
app.use(express.json());

const port = process.env.PORT || 3000;
const connectionString = process.env.ATLAS_URI;

const client = new MongoClient(connectionString);

async function main() {
    try {
        await client.connect();
        const db = client.db("kommunity_db");
        console.log("Conectado com sucesso ao MongoDB");

        app.get("/", (req, res) => {
            res.send("Olá mundo!");
        });

        app.use("/events", eventRoutes(db));

        app.use("/users", userRoutes(db));

        app.listen(port, () => {
            console.log(`Servidor rodando na porta ${port}`);
        });
    } catch (e) {
        console.error("Erro de conexão com o MongoDB:", e);
    }
}

main();
