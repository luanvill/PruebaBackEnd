import { Request, Response } from "express";
import { getRepository } from "typeorm";
import { Movimiento } from "../entities/Movimiento";

export const postMovimiento = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const movimiento = new Movimiento();
        getRepository(Movimiento).merge(movimiento, req.body);
        const movimientoD = await getRepository(Movimiento).create(movimiento);
        const newMovimiento = await getRepository(Movimiento).save(movimientoD);
        return res.status(200).json({
            code: 200,
            success: true,
            message: "Se ha creado el movimiento",
            data: {
                secuenciaMovimiento: newMovimiento.secuencia,
            },
        });
    } catch (error) {
        return res.status(500).json({
            code: 500,
            success: false,
            message: "Ha ocurrido un error inesperado.",
            errorData: error
        });
    }
};

