import { Request, Response } from "express";
import { getRepository } from "typeorm";

import { Item } from "../entities/Item";

export const putItem = async (
    req: Request,
    res: Response
): Promise<Response> => {
    try {
        const item = await getRepository(Item).findOne({
            where: {codigoItem: req.params.codigoItem},
        });
        if (!item) {
            return res.status(400).json({
                code: 400,
                success: false,
                message: "El item con el codigo ingresado no existe",
                
            });
        }
        
        getRepository(Item).merge(item, req.body);
        
        const itemActual = await getRepository(Item).save(item);
        return res.status(200).json({
            code: 200,
            success: true,
            message: "OK",
            data: { "codigoItem": itemActual.codigoItem,}
        });
    } catch (error) {
        return res.status(500).json({
            code: 500,
            success: false,
            message: "Ha ocurrido un error inesperado.",
            errorData: error,
        });
    }
}