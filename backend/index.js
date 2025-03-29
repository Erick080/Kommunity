const dotenv = require("dotenv");
dotenv.config();

const express = require("express");
const app = express();
const port = process.env.PORT;

app.get("/", (req, res) => {
  res.send("Ola mundo! Como isso funciona?");
});

app.listen(port, () => {
  console.log(`Servidor rodando na porta ${port}`);
});
