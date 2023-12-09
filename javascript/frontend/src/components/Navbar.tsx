import {Link} from "react-router-dom"
import "./Navbar.css"

const Navbar = ()=>{
return(
<div className="navbar">
    <div className="navbarMenu">
        <ul className="linkListFlex">
            <li><Link to="/">Powrót do Strony Głównej</Link></li>
            <li>|</li>
            <li>Dodaj Nowy Relikt</li>
        </ul>
    </div>
</div>
)

}


export default Navbar;