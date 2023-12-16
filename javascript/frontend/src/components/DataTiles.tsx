import { RelictBase, TierInfo } from '../types';
import './DataTiles.css'
import { Link } from 'react-router-dom';
interface DataTilesProps {
  data: RelictBase;
}

const relictImg: { [key: string]: string } = {
  LITH: '/images/LithRelicIntact.png',
  MESO: '/images/MesoRelicIntact.png',
  NEO: '/images/NeoRelicIntact.png',
  AXI: '/images/AxiRelicIntact.png',
};

function DataTiles({ data }: DataTilesProps): JSX.Element {
  const tierInfo:string  = relictImg[data.tier];

  if (!tierInfo) {
    // Handle cases where tier information is not available
    return <div className="data-tiles">Nie znaleziono danych dotyczących Reliktów.</div>;
  }


  return (
    <div className="data-tiles">
      {/* Render image if imgPath exists */}
      {tierInfo && (
      <Link to={`/relict/${data.relictID}`}>
      <img src={tierInfo} alt={data.tier} width="160" height="160" />
      </Link>)} 
      <br/>
      <label>{data.tier} {data.name}</label>
    </div>
  );
}

export default DataTiles;
