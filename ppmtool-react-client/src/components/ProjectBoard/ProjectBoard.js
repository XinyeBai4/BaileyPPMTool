import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Backlog from './Backlog';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import { getBacklog } from '../../actions/backlogActions';


class ProjectBoard extends Component {
    render() {
        const {id} = this.props.match.params;

        return (
            // <!-- Project Board Starts Here MIND OTHER COMPONENTS WHEN COPY AND PASTING -->
    
            <div className="container">
                <Link to={`/addProjectTask/${id}`} className="btn btn-primary mb-3">
                    <i className="fas fa-plus-circle"> Create Project Task</i>
                </Link>
                <br />
                <hr />
                <Backlog />
            </div>

            // <!-- PROJECT BOARD ENDS HERE -->
        )
    }
}

ProjectBoard.propTypes = {
    backlog: PropTypes.object.isRequired,
    getBacklog: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
    backlog: state.backlog
});

export default connect(mapStateToProps, getBacklog)(ProjectBoard);