import { Router } from "express";
import { validarPutItem } from "../middlewares/validarItem";
import {putItem} from "../controllers/item.controller"

const router = Router();

router.put("/:codigoItem",validarPutItem,putItem);

export default router;