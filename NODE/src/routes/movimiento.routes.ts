import { Router } from "express";
import { validarPostMovimiento } from "../middlewares/validarMovimiento";

import {postMovimiento} from "../controllers/movimiento.controller";

const router = Router();

router.post('/',validarPostMovimiento,postMovimiento);

export default router;