const express = require("express");
const fs = require("fs");
const cors = require("cors");
const port = 1357;

const app = express();
app.use(cors());

app.get("/ping", (_, res) => {
  setTimeout(() => {
    res.json({ message: "pong" });
  }, 1000);
});

app.get("/postings", (_, res) => {
  const meinZeug = JSON.parse(fs.readFileSync("./db.json", "utf8"));
  res.json({ zeug: meinZeug });
});

app.listen(port, () => console.log(`🚀 App listening on port ${port}.`));
