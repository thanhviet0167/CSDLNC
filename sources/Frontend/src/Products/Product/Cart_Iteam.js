import React, { useEffect, useState } from "react";


const Cart_Iteam = ({price, total, number, id, handle_update_plus, handle_update_moin, handle_remove}) =>{


    const handle_plus = () =>{

        handle_update_plus(id)
    }

    const handle_moin = () =>{
        //console.log("Hello")
        handle_update_moin(id)
    }

    const remove = () =>{
        //console.log("Hello")
        handle_remove(id)
    }
    

    return(
        
        <div className="product">
                <div className="product-image">
                    <img src="images/e1.png" alt="" />
                </div>
                <div className="product-details">
                    <div className="product-title">Dingo Dog Bones</div>
                    <p className="product-description">
                        The best dog bones of all time. Holy crap. Your dog will be
                        begging for these things! I got curious once and ate one myself.
                        I'm a fan.
                    </p>
                </div>
                <div className="product-price">{price}</div>
                <div className="product-quantity">
                    <input type="number" value={number} min='1' max='100' step='1'/>
                    
                </div>
               
                <div className="product-removal">
                    <button type="button" class="btn btn-info" style={{height:"25px", textAlign:'center'}} onClick = {()=>handle_plus()}>+</button>
                    <button type="button" class="btn btn-warning" style={{height:"25px", textAlign:'center'}} onClick = {()=>handle_moin()}>-</button>
                    <button className="remove-product" onClick={()=>remove()}>Remove</button>
                </div>
                <div className="product-line-price">{total}</div>
         </div>
        
    );
};


export default Cart_Iteam;



