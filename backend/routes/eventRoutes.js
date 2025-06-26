const express = require("express");

module.exports = (db) => {
    const router = express.Router();
    const eventsCollection = db.collection("events");

    // POST /events/createEvent
    router.post("/createEvent", (req, res) => {
        const { tipo, data, local, descricao } = req.body;

        if (!tipo || !data || !local || !descricao) {
            return res.status(400).json({ erro: "Todos os campos são obrigatórios." });
        }

        const novoEvento = {
            tipo: String(tipo),
            data: new Date(data),
            local: String(local),
            descricao: String(descricao),
            criadoEm: new Date()
        };

        const resultado = eventsCollection.insertOne(novoEvento)
            .then(resultado => {
                res.status(201).json({ mensagem: "Evento criado", id: resultado.insertedId });
            })

            .catch(e => {
                res.status(500).json({ erro: "Erro interno" });
            });

    });

    return router;
};

