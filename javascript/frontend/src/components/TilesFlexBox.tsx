import { CSSProperties } from "react";

const TilesFlexBox = ({children}) => {
  const boxStyle:CSSProperties = {
    display: 'flex',
    flexDirection: 'row',
    flexWrap:'wrap',
    justifyContent: 'flex-start',
    alignItems: 'center',
    alignContent: 'flex-start',
    
    backgroundColor: '#9AD0C2',
    border: 'black 3px solid',
    borderRadius: '40px'
  }
  
  return (<>
  <hr/>
    <div style={boxStyle}>
      {children}
    </div>
    </>
  );
};
export default TilesFlexBox;