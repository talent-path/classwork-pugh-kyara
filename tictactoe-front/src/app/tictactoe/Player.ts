import {Board} from "./Board";
import {Position} from "./Position";

export enum PlayerToken{
    X,
    O
}

export interface Player
{
    token: PlayerToken;
    isX: boolean;
}