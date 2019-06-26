import React, { Fragment } from "react";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
import PropTypes from "prop-types";


const Banner = () => {
    return (
        <div className="banner-div">
            <h1 className="offset-1 col-6 text-white banner-text-large">Top rated learning courses.</h1>
            <h1 className="offset-1 col-6 text-white banner-text-small">For students who like to purchase a course, the minimum is
                JP¥1,400.
            Pacific Summer Time ends on June 27th at 11:59pm.</h1>
        </div>
    );
}

//Banner.PropTypes ={};

//
const mapStateToProps = state => ({});
export default connect(mapStateToProps)(Banner);