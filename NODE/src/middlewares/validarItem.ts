import { body, param } from "express-validator";

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
            message: "Parametros faltantes para actualizar Item",
            errorData: errs.mapped(),
        });
    }
    next();
};

export const validarPutItem = [
    param("codigoItem", "El codigo del item es obligatorio").not().isEmpty(),
    body("grupo", "El grupo del Item es obligatorio").not().isEmpty(),
    body("subgrupo", "El subgrupo del Item es obligatorio").not().isEmpty(),
    body("descripcionItem", "La descripcionItem del Item es obligatorio").not().isEmpty(),
    body("stock", "El stock del Item es obligatorio").not().isEmpty(),
    body("precio", "El precio del Item es obligatorio").not().isEmpty(),
    body("codigoBodega", "El codigoBodega del Item es obligatorio").not().isEmpty(),
    body("estado", "El estado del Item es obligatorio").not().isEmpty(),
    paramsFaltantes,
];

