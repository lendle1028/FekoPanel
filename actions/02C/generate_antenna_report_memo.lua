--[[
AUTOMATIC QUICK REPORT GENERATION FOR ANTENNA PATTERN ANALYSIS
==============================================================
This script loads the specified model.  It then creates various
views and graphs that display the far field pattern.  These 
views are then exported to a PDF report
]]--

modelName = {}
modelName[1] = "Horn"


    app = pf.GetApplication()
    app:NewProject()
    app:OpenFile("${fileName}")

    selectedModel   = app.Models[1]
    selectedConfig1 = selectedModel.Configurations[1]

    ffData      = selectedConfig1.FarFields[1] -- This is a handle on the far field data itself

    view3D = app.Views[1]
    view3D.MeshRendering.ModelOpacity = 60
    ffPlot = view3D.Plots:Add(ffData)
    ffPlot.Label = "ff3D"
    ffPlot.Quantity.ValuesScaledToDB = true
    view3D:ZoomToExtents()

    view3D_top = view3D:Duplicate() 
    view3D_top:SetViewDirection(pf.Enums.ViewDirectionEnum.Top)
    view3D_top:ZoomToExtents()

    view3D_right = view3D:Duplicate()
    view3D_right:SetViewDirection(pf.Enums.ViewDirectionEnum.Right)
    view3D_right:ZoomToExtents()

    view3D_front = view3D:Duplicate()
    view3D_front:SetViewDirection(pf.Enums.ViewDirectionEnum.Front)
    view3D_front:ZoomToExtents()

    polarGraph = app.PolarGraphs:Add()
    ffTracePhi_00 = polarGraph.Traces:Add(ffData)
    ffTracePhi_00.IndependentAxis = "Theta (wrapped)"
    ffTracePhi_00.Quantity.ValuesScaledToDB = true
    ffTracePhi_90 = polarGraph.Traces:Add(ffData)
    ffTracePhi_90.IndependentAxis = "Theta (wrapped)"
    ffTracePhi_90.Quantity.ValuesScaledToDB = true
    ffTracePhi_90:SetFixedAxisValue(ffTracePhi_90.FixedAxes[2],90,"deg")
    polarGraph:ZoomToExtents()
    polarGraph.Title.Text = "Gain"
    polarGraph.Legend.Position = pf.Enums.GraphLegendPositionEnum.OverlayTopRight
    polarGraph.BackColour = pf.Enums.ColourEnum.LightGrey
    polarGraph:Restore()

    quickReport = app:CreateQuickReport("AntennaQuickReport", 
                                            pf.Enums.ReportDocumentTypeEnum.PDF)
    quickReport.DocumentHeading = "Antenna: Automated Quick Report"
    quickReport:SetPageTitle(view3D.WindowTitle, "Isometric View")
    quickReport:SetPageTitle(view3D_top.WindowTitle, "Top View")
    quickReport:SetPageTitle(view3D_right.WindowTitle, "Right View")
    quickReport:SetPageTitle(view3D_front.WindowTitle, "Front View")
    quickReport:SetPageTitle(polarGraph.WindowTitle, "Theta Cuts")
    quickReport:Generate()
    
    --app:SaveAs(modelName[index].."AutomatedSession.pfs")
