const express = require("express");
const cors = require("cors");
const port = 1357;

const app = express();
app.use(cors());

app.get("/ping", (_, res) => {
  setTimeout(() => {
    res.json({ message: "pong" });
  }, 1000);
});

app.listen(port, () => console.log(`🚀 App listening on port ${port}.`));
