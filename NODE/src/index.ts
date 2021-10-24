import express from "express";
import cors from "cors";
import { createConnection } from "typeorm";
import "reflect-metadata";

import movimientoR from "./routes/movimiento.routes";
import itemR from "./routes/item.routes";


const PORT = 8082;

const app = express();
createConnection();

app.use(cors());
app.use(express.json());
app.use("/movimientos", movimientoR );
app.use("/items", itemR);

app.listen(PORT);
console.log(`Server open in port: ${PORT}`);