/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2012, Xcoo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package casmi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Example launcher.
 *
 * @author T. Takeuchi
 */
public class AllExample extends JFrame {

    static final String[][] EXAMPLES = {
        { "casmi", "" },
        { "casmi.CursorExample",                               "Cursor Example"              },
        { "casmi.FPSExample",                                  "FPS Example"                 },
        { "casmi.FullScreenExample",                           "Full Screen Example"         },
        { "casmi.KeyboardExample",                             "Keyboard Example"            },
        { "casmi.KeyboardSimpleExample",                       "Simple Keyboard Example"     },
        { "casmi.MouseExample",                                "Mouse Example"               },
        { "casmi.MouseWheelExample",                           "Mouse Wheel Example"         },
        { "casmi.ScreenshotExample",                           "Screenshot Example"          },
        { "casmi.TrackballExample",                            "Trackball Example"           },

        { "casmi.graphics", "" },
        { "casmi.graphics.AlphaExample",                       "Alpha Example"               },
        { "casmi.graphics.BackgroundExample",                  "Background Example"    },
        { "casmi.graphics.CameraExample",                      "Camera Example"              },
        { "casmi.graphics.LightExample",                       "Light Example"               },
        { "casmi.graphics.RemoveExample",                      "Remove Example"              },
        { "casmi.graphics.RotateExample",                      "Rotate Example"              },

        { "casmi.graphics.color", "" },
        { "casmi.graphics.color.ColorSetExample",              "ColorSet Example"            },
        { "casmi.graphics.color.GrayColorExample",             "GrayColor Example"           },
        { "casmi.graphics.color.HSBColorExample",              "HSBColor Example"           },
        { "casmi.graphics.color.LerpColorExample",             "LerpColor Example"           },

        { "casmi.graphics.element", "" },
        { "casmi.graphics.element.ArcExample",                         "Arc Example"                 },
        { "casmi.graphics.element.BezierExample",                      "Bezier Example"              },
        { "casmi.graphics.element.BoxExample",                         "Box Example"                 },
        { "casmi.graphics.element.BoxTextureExample",                  "Box Texture Example"         },
        { "casmi.graphics.element.CircleExample",                      "Circle Example"              },
        { "casmi.graphics.element.ConeExample",                        "Cone Example"                },
        { "casmi.graphics.element.CurveExample",                       "Curve Example"               },
        { "casmi.graphics.element.DashedLineExample",                  "DashedLine Example"               },
        { "casmi.graphics.element.EllipseExample",                     "Ellipse Example"             },
        { "casmi.graphics.element.LineExample",                        "Line Example"                },
        { "casmi.graphics.element.LinesExample",                       "Lines Example"               },
        { "casmi.graphics.element.PointExample",                       "Point Example"               },
        { "casmi.graphics.element.PolygonExample",                     "Polygon Example"             },
        { "casmi.graphics.element.QuadExample",                        "Quad Example"                },
        { "casmi.graphics.element.QuadTextureExample",                 "Quad Texture Example"        },
        { "casmi.graphics.element.RectExample",                        "Rect Example"                },
        { "casmi.graphics.element.RectRotateExample",                  "RectRotate Example"                },
        { "casmi.graphics.element.RoundrectExample",                   "Roundrect Example"           },
        { "casmi.graphics.element.SphereExample",                      "Sphere Example"              },
        { "casmi.graphics.element.SphereTextureExample",               "Sphere Texture Example"      },
        { "casmi.graphics.element.TextBoxExample",                     "TextBox Example"             },
        { "casmi.graphics.element.TextExample",                        "Text Example 1"              },
        { "casmi.graphics.element.TriangleExample",                    "Triangle Example"            },

        { "casmi.graphics.font", "" },
        { "casmi.graphics.font.FontExample",                   "Font Example"                },

        { "casmi.graphics.gradation", "" },
        { "casmi.graphics.gradation.GradationBezierExample",   "Gradation Bezier Example"    },
        { "casmi.graphics.gradation.GradationBoxExample",      "Gradation Box Example"       },
        { "casmi.graphics.gradation.GradationExample",         "Gradation Example"           },


        { "casmi.graphics.material", "" },
        { "casmi.graphics.material.MaterialExample",           "Material Example"              },

        { "casmi.tween", "" },
        { "casmi.tween.TweenCursorExample",                    "Tween Cursor Example"        },
        { "casmi.tween.TweenEquationsExample",                 "Tween Equations Example"     },
        { "casmi.tween.TweenExample",                          "Tween Example"               },
        { "casmi.tween.TweenRepeatExample",                    "Tween Repeat Example"        },

        { "casmi.ui", "" },
        { "casmi.ui.PopupMenuExample",                         "PopupMenu Example"              },

        { "casmi.util", "" },
        { "casmi.util.NoiseExample",                           "Noise Example"              },
        { "casmi.util.RandomExample",                          "Random Example"              },
    };

    JTree tree;
    AppletFrame currentApplication;

    public AllExample() {
        super();

        setTitle("Example Launcher");
        setBounds(50, 50, 300, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Examples");

        DefaultMutableTreeNode node = null;
        for (String[] s : EXAMPLES) {
            if (s[1].isEmpty()) {
                node = new DefaultMutableTreeNode(s[0]);
                rootNode.add(node);
            } else {
                node.add(new DefaultMutableTreeNode(s[1]));
            }
        }

        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        tree = new JTree(model);

        JScrollPane sp = new JScrollPane();
        sp.getViewport().setView(tree);

        JButton button = new JButton("Run");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                TreePath path = tree.getSelectionPath();
                if (path == null) {
                    return;
                }

                if (currentApplication != null) {
                    currentApplication.dispose();
                }

                String title = path.getLastPathComponent().toString();

                for (String[] s : EXAMPLES) {
                    if (title.equals(s[1])) {
                        currentApplication = AppletRunner.run(s[0], s[1]);
                        break;
                    }
                }
            }
        });

        getContentPane().add(sp, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AllExample();
    }
}
