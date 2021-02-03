import React, { Component } from 'react'
import ProjectTasks from './ProjectTasks/ProjectTasks'

class Backlog extends Component {
    render() {
        const {project_tasks_prop} = this.props;
        const tasks = project_tasks_prop.map(project_task => (
            <ProjectTasks key={project_task.id} project_task={project_task} />
        ));

        // let todoItems = [];
        // let inProgressItems = [];
        // let doneItems = [];

        for (let i=0; i < tasks.length; i++) {
            console.log(tasks[i]);
        }
        

        return (
            
            // <!-- Backlog STARTS HERE -->
            
            <div className="container">
                <div className="row">
                    <div className="col-md-4">
                        <div className="card text-center mb-2">
                            <div className="card-header bg-secondary text-white">
                                <h3>TO DO</h3>
                            </div>
                        </div>
                        {
                            // <!-- SAMPLE PROJECT TASK STARTS HERE -->
                        }
                        {tasks}
                        {
                            // <!-- SAMPLE PROJECT TASK ENDS HERE -->
                        }
                    </div>
                    <div className="col-md-4">
                        <div className="card text-center mb-2">
                            <div className="card-header bg-primary text-white">
                                <h3>In Progress</h3>
                            </div>
                        </div>
                        {
                            // <!-- SAMPLE PROJECT TASK STARTS HERE -->
                        }
                        
                        {
                            // <!-- SAMPLE PROJECT TASK ENDS HERE -->
                        }
                    </div>
                    <div className="col-md-4">
                        <div className="card text-center mb-2">
                            <div className="card-header bg-success text-white">
                                <h3>Done</h3>
                            </div>
                        </div>
                        {
                            // <!-- SAMPLE PROJECT TASK STARTS HERE -->
                        }
                       
                        {
                            // <!-- SAMPLE PROJECT TASK ENDS HERE -->
                        }
                    </div>
                </div>
            </div>
            
            // <!-- Backlog ENDS HERE -->
            
        )
    }
}

export default Backlog;