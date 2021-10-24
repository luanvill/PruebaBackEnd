import { body } from "express-validator";

import { NextFunction, Request, Response } from "express";
import { validationResult } from "express-validator";

const paramsFaltantes = (
    req: Request,
    res: Response,
    next: NextFunction
) => {
    const errs = validationResult(req);
    if (!errs.isEmpty()) {
        return res.status(400).json({
            code: 400,
            message: "Datos Faltantes",
            errorData: errs.mapped(),
        });
    }
    next();
};

export const validarPostMovimiento = [
    body("codigoItem", "El codigo Item es obligatorio").not().isEmpty(),
    body("fechaHoraMovimiento", "La fecha y hora del Movimiento es obligatoria").not().isEmpty(),
    body("tipoMovimiento", "El tipo de Movimiento es obligatorio").not().isEmpty(),
    body("cantidad", "La cantidad del Movimiento es obligatoria").not().isEmpty(),
    paramsFaltantes,
];

