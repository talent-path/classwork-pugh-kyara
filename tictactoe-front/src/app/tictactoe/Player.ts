import {Board} from "./Board"

export enum PlayerToken{
    X,
    O
}

export interface Player
{
    token: PlayerToken;
    isX: boolean;
}