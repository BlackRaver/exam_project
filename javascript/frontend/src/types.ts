export interface RelictBase {
    relictID: number,
    name: string,
    tier: number
}

export interface RelictDetails {
    relictID: number;
    name: string;
    tier: number;
    dropList: DropTable[];
}

export interface DropTable {
    id: number;
    primeItem: PrimeItem;
    rarity: string;
}

export interface PrimeItem {
    name: string;
    ducats: number;
}

export interface TierInfo {
    tierLabel: string;
    imgPath: string;
  }

  export interface RelictData {
    relictID: number;
    name: string;
    tier: number;
    drop: {
      id: number;
      primeItem: {
        elementID: number;
        name: string;
        ducats: number;
      };
      rarity: 'common' | 'uncommon' | 'rare';
    }[];
  }