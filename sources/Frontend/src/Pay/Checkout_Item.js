import React, { useEffect, useState } from "react";



const Checkout_Item = ({ number, total, id}) => {





    return (
        <>
            <div className="form-group">
                <div className="col-sm-3 col-xs-3">
                    <img className="img-responsive" src="images/e1.png" />
                </div>
                <div className="col-sm-6 col-xs-6">
                    <div className="col-xs-12">Product id : {id}</div>
                    <div className="col-xs-12"><small>Quantity : <span>{number}</span></small></div>
                </div>
                <div className="col-sm-3 col-xs-3 text-right">
                    <h6><span>$</span>{total}</h6>
                </div>
            </div>
            <div className="form-group"><hr /></div>
        </>

    );
};


export default Checkout_Item;



