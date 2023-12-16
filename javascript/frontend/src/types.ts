export interface RelictBase {
    relictID: number,
    name: string,
    tier: string
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
    imgPath: string;
  }

  export interface RelictData {
    relictID: number;
    name: string;
    tier: 'LITH' | 'MESO' | 'NEO' | 'AXI';
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