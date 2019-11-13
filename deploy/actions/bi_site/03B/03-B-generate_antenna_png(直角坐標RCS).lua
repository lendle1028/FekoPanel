modelName = {}
modelName[1] = "sphere-9.4GHz_FMM_standard_bi-static" 


app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--{filename}.fek

    -- Add a Cartesian surface graph and a surface plot 
    
graph = app.CartesianSurfaceGraphs:Add()
farFieldPlot = graph.Plots:Add(app.Models[1].Configurations[1].FarFields[1])

    -- Change properties of the graph 

graph.Grid.Minor.Visible = true

graph:Restore()
graph:SetSize(800,400)
graph:ExportImage("2D-RCS", "png", 1000, 500)