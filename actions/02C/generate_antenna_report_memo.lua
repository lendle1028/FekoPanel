--[[
AUTOMATIC QUICK REPORT GENERATION FOR ANTENNA PATTERN ANALYSIS
==============================================================
This script loads the specified model.  It then creates various
views and graphs that display the far field pattern.  These 
views are then exported to a PDF report
]]--

modelName = {}
modelName[1] = "${modelName}"

app = pf.GetApplication()
app:NewProject()
app:OpenFile(modelName[1]..".fek")

selectedModel   = app.Models[modelName[1]]
selectedConfig1 = selectedModel.Configurations[1]

ffData      = selectedConfig1.FarFields[1] -- This is a handle on the far field data itself

view3D = app.Views[1]
ffPlot = view3D.Plots:Add(ffData)
ffPlot.Label = "ff3D"
ffPlot.Quantity.ValuesScaledToDB = true

view3D_top = view3D:Duplicate() 
view3D_top:SetViewDirection(pf.Enums.ViewDirectionEnum.Top)

view3D_right = view3D:Duplicate()
view3D_right:SetViewDirection(pf.Enums.ViewDirectionEnum.Bottom)

view3D_right = view3D:Duplicate()
view3D_right:SetViewDirection(pf.Enums.ViewDirectionEnum.Left)

view3D_right = view3D:Duplicate()
view3D_right:SetViewDirection(pf.Enums.ViewDirectionEnum.Right)

view3D_front = view3D:Duplicate()
view3D_front:SetViewDirection(pf.Enums.ViewDirectionEnum.Front)

view3D_right = view3D:Duplicate()
view3D_right:SetViewDirection(pf.Enums.ViewDirectionEnum.Back)

polarGraph = app.PolarGraphs:Add()
ffTracePhi_00 = polarGraph.Traces:Add(ffData)
ffTracePhi_00.Quantity.Type = pf.Enums.FarFieldQuantityTypeEnum.RCS
ffTracePhi_00.Quantity.Component = pf.Enums.FarFieldQuantityComponentEnum.Total
ffTracePhi_00.Quantity.ValuesScaledToDB = true
 
report = app:CreateQuickReport("RCS_report", 
                                        pf.Enums.ReportDocumentTypeEnum.PDF)
report.DocumentHeading = "RCS_report"

    -- Generate the document

report:GenerateAndOpen()
