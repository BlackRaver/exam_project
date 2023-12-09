import { RelictBase, TierInfo } from '../types';
import './DataTiles.css'
import { Link } from 'react-router-dom';
interface DataTilesProps {
  data: RelictBase;
}

const tierMap: { [key: number]: TierInfo } = {
  1: {tierLabel: 'LITH', imgPath: '/images/LithRelicIntact.png'},
  2: {tierLabel: 'MESO', imgPath: '/images/MesoRelicIntact.png'}, 
  3: {tierLabel: 'NEO', imgPath:  '/images/NeoRelicIntact.png'}, 
  4: { tierLabel: 'AXI', imgPath: '/images/AxiRelicIntact.png' },
};

function DataTiles({ data }: DataTilesProps): JSX.Element {
  const tierInfo:TierInfo  = tierMap[data.tier];

  if (!tierInfo) {
    // Handle cases where tier information is not available
    return <div className="data-tiles">Nie znaleziono danych dotyczących Reliktów.</div>;
  }


  return (
    <div className="data-tiles">
      {/* Render image if imgPath exists */}
      {tierInfo.imgPath && (
      <Link to={`/relict/${data.relictID}`}>
      <img src={tierInfo.imgPath} alt={tierInfo.tierLabel} width="160" height="160" />
      </Link>)} 
      <br/>
      <label>{tierInfo.tierLabel} {data.name}</label>
    </div>
  );
}

export default DataTiles;
