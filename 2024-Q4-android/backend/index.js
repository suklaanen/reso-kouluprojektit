const express = require('express');
const { Pool } = require('pg');
const path = require('path');
require('dotenv').config({ path: path.resolve(__dirname, '../.env') }); 
const app = express();
const port = 8080;

const connectionString = process.env.DATABASE_URL

const pool = new Pool({connectionString,});

app.use(express.json());

// kaikki koiraprofiilit
app.get('/dogs', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM dogs');
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// uusi koira
app.post('/dogs', async (req, res) => {
  const { dogName, dogGender, dogBreed } = req.body;
  try {
    const result = await pool.query(
      'INSERT INTO dogs (dogName, dogGender, dogBreed) VALUES ($1, $2, $3) RETURNING *',
      [dogName, dogGender, dogBreed]
    );
    res.json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// muut API-reitit tarpeen mukaan...

app.listen(port, () => {
  console.log(`Backend running on http://localhost:${port}`);
});
