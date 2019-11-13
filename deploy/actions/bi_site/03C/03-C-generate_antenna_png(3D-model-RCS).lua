modelName = {}
modelName[1] = "shpere_9.4GHz_bi-static"


app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--sphere.fek


    -- Create graphs 
view = app.Views:Add(app.Models[1].Configurations[1])
view.Plots:Add(app.Models[1].Configurations[1].FarFields[1])

    -- Export all graphs in the 'CartesianGraphCollection'

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("單雙站3D-RCS"..index, "png")
end
