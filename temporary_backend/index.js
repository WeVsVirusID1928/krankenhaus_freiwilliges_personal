const express = require("express");
const fs = require("fs");
const cors = require("cors");
const bodyParser = require("body-parser");
const port = 1357;

const app = express();
app.use(cors());
app.use(bodyParser.json());

app.get("/ping", (_, res) => {
  setTimeout(() => {
    res.json({ message: "pong" });
  }, 1000);
});

app.get("/postings", (_, res) => {
  const { postings } = JSON.parse(fs.readFileSync("./db.json", "utf8"));
  res.json({ postings });
});

app.post("/postings", (req, res) => {
  const { postings } = JSON.parse(fs.readFileSync("./db.json", "utf8"));

  fs.writeFileSync(
    "./db.json",
    JSON.stringify({ postings: postings.concat(req.body) }),
    "utf8"
  );

  const { postings: newPostings } = JSON.parse(
    fs.readFileSync("./db.json", "utf8")
  );
  res.json({ postings: newPostings });
});

app.listen(port, () => console.log(`🚀 App listening on port ${port}.`));
